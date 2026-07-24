package algorithm.bfs;

import java.util.Arrays;

public class dijkstra {
    public static void main(String[] args) {

        PQ pq = new PQ(new int[]{1,4,5,6,7,2,3});
        System.out.println(pq.heap.arr[0]);
        System.out.println(pq.heap.arr.length);
        for(int a: pq.heap.arr){
            System.out.print(a);
        }
        Heap heap = new Heap(new int[]{1,4,5,6,7,2,3});
    }
}


class PQ{
    private int[] arr;
    public Heap heap;

    public PQ(){
        this.heap = new Heap();
    }

    public PQ(int[] arr){
        this.heap = new Heap(0);
        for(int a: arr){
            heap.insert(a);
        }
    }
}

class Heap{
    //zero-based 기반
    int[] arr;

    public Heap(){
        arr = new int[0];
    }
    public Heap(int size){
        arr = new int[size];
    }
    public Heap(int[] arr){
        this.arr = arr;
        init();
    }
    void init(){
        int lastParentIdx = arr.length / 2 - 1;

        for(int idx = lastParentIdx; idx >= 0; idx--){
            siftDown(idx);
        }
    }
    void siftDown(int idx) {
        int p_idx = idx;
        int l_idx = p_idx * 2 + 1;
        int r_idx = p_idx * 2 + 2;

        if (l_idx >= arr.length){ return;}
        if (r_idx >= arr.length){ r_idx = l_idx;}
        int max_idx = arr[l_idx] > arr[r_idx]?l_idx:r_idx;
        if(arr[p_idx] >= arr[max_idx]) return;
        swap(max_idx, p_idx);
        siftDown(max_idx);
    }
    // 이미 힙정렬 되어있음을 상정한다.
    void siftUp(int idx) {
        if(idx == 0) return;
        int p_idx;

        while(idx > 0){
            p_idx = (idx - 1) / 2;
            if(arr[idx] <= arr[p_idx]){
                break;
            }
            swap(idx,p_idx);
            idx = p_idx;
        }
    }
    void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    void insert(int val){
        int[] newarr = Arrays.copyOf(arr,arr.length + 1);
        newarr[newarr.length - 1] = val;
        arr = newarr;
        siftUp(arr.length - 1);
    }
    int delete(){
        int result = arr[0];
        arr[0] = arr[arr.length - 1];
        arr = Arrays.copyOf(arr, arr.length - 1);
        siftDown(0);

        return result;
    }
}
