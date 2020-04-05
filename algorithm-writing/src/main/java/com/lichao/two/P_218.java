package com.lichao.two;

import java.util.*;

class P_218 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {

        if (buildings.length == 0) {
            return new ArrayList();
        }
        int[][] heap = new int[buildings.length * 2][2];
        int size = 0;
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            while (i + 1 < buildings.length) {
                if (buildings[i + 1][2] == building[2] && buildings[i + 1][0] <= building[1]) {
                    building[1] = Math.max(building[1], buildings[i + 1][1]);
                    i++;
                } else {
                    break;
                }
            }
            while (i + 1 < buildings.length) {
                if (buildings[i + 1][2] < building[2]
                        && buildings[i + 1][0] >= building[0]
                        && buildings[i + 1][1] <= building[1]) {
                    i++;
                } else {
                    break;
                }

            }
            addHeap(heap, size++, new int[]{building[0], building[2]});
            addHeap(heap, size++, new int[]{building[1], building[2]});
        }


        heap = Arrays.copyOf(heap, size);
        sort(heap);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Arrays.asList(heap[0][0], heap[0][1]));
        set.add(heap[0][1]);
        for (int i = 1; i < heap.length; i++) {
            if (i + 1 < heap.length) {
                if (heap[i][0] == heap[i + 1][0] && heap[i][1] == heap[i + 1][1]) {
                    i++;
                    continue;
                }
            }
            Iterator<Integer> s = set.iterator();
            int status = 0;
            while (s.hasNext()) {
                int next = s.next();
                if (heap[i][1] < next) {
                    status = -1;
                    break;
                } else if (heap[i][1] == next) {
                    status = 1;
                }
            }
            if (status == 0) {
                add(ret, heap[i][0], heap[i][1]);
                set.add(heap[i][1]);
            } else if (status == 1) {
                set.remove(heap[i][1]);
                if (set.isEmpty()) {
                    sub(ret, heap[i][0], 0);
                } else {
                    sub(ret, heap[i][0], Collections.max(set));
                }
            } else {
                if (!set.contains(heap[i][1])) {
                    set.add(heap[i][1]);
                } else {
                    set.remove(heap[i][1]);
                }
            }
        }
        return ret;
    }




    static void add(List<List<Integer>> list, Integer x, Integer y) {
        if (list.isEmpty()) {
            list.add(Arrays.asList(x, y));
        } else {
            List<Integer> lest = list.get(list.size() - 1);
            if ((lest.get(0).equals(x))) {
                if (lest.get(1) < y)
                    lest.set(1, y);
            } else {
                list.add(Arrays.asList(x, y));
            }
        }
    }




    static void sub(List<List<Integer>> list, Integer x, Integer y) {
        if (list.isEmpty()) {
            list.add(Arrays.asList(x, y));
        } else {
            List<Integer> lest = list.get(list.size() - 1);
            if ((lest.get(0).equals(x))) {
                if (lest.get(1) > y)
                    lest.set(1, y);
            } else {
                list.add(Arrays.asList(x, y));
            }
        }
    }




    static void sort(int[][] heap) {
        for (int i = heap.length - 1; i > 0; i--) {
            swap(heap, 0, i);
            maxHeap(heap, i, 0);
        }
    }


    //     0
    //    1  2
    //  3




    static void addHeap(int[][] heap, int heapSize, int[] newNode) {
        heap[heapSize] = newNode;
        adjust(heap, heapSize);
    }




    static void adjust(int[][] heap, int index) {
        if (index == 0) {
            return;
        }

        int parent = (index - 1) / 2;
        if (heap[parent][0] < heap[index][0]) {
            swap(heap, parent, index);
            adjust(heap, parent);
        }
    }




    static void maxHeap(int[][] heap, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int max = (left < heapSize && heap[index][0] < heap[left][0]) ? left : index;
        max = (right < heapSize && heap[max][0] < heap[right][0]) ? right : max;
        if (max != index) {
            swap(heap, index, max);
            maxHeap(heap, heapSize, max);
        }
    }




    static void swap(int[][] heap, int index1, int index2) {
        int[] temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }




    public static void main(String[] args) {
//        int[][] input = {{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}};
        int[][] input = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        int [][] input1 = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
        int[][] input1 = {{1, 10001, 10000}, {1000, 10001, 11001}
                , {10000, 10001, 1}};

        List<List<Integer>> ret = getSkyline(input1);
        System.out.println(ret);
    }
}