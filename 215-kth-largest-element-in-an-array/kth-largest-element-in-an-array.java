class Solution {
    private int size = 0;
    public int findKthLargest(int[] nums, int k) {
        size = nums.length;
        buildHeap(nums);
        int ans=0;
        for(int i=0;i<k;i++)
        {
            ans = extractMax(nums);
        }
        return ans;
    }


    public int extractMax(int[] arr)
    {
        int ans = arr[0];
        swap(arr,0,size-1);
        size--;
        heapify(arr,0);
        return ans;
    }
    void heapify(int arr[], int i) {
        int li = i * 2 + 1;
        int ri = i * 2 + 2;
        int largest = i;

        if (li < size && arr[li] > arr[largest]) {
            largest = li;
        }
        if (ri < size && arr[ri] > arr[largest]) {
            largest = ri;
        }

        if (largest != i) {
            swap(arr,i,largest);
            heapify(arr,largest);
        }
    }

    void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    void buildHeap(int[] arr) {
        //BRMIN
        int i = (size - 2) / 2;
        for (; i >= 0; i--) {
            heapify(arr, i);
        }
    }
}