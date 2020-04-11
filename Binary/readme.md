

# Binary Search 

###### Pseudo Recursive Code for Binary search
```
//Pseudo code for Binary search
k = input();

bool binarysearch(array, l, r, element){
  if(l > r) return false
  int mid = (l + (r-l)/2) ;
  if(arr[mid] == element) return true
  else if(arr[mid] > element) return binarysearch(array, l, mid -1 , element)
  else return binarysearch(array, mid+1, r , element)
}
for(i=1; i < n;i++){
  if(i==n){
     print("Linear search number: " + i)
  }
}
```

```
Big O notation:

Binary search - O(log n)
```

[Binary Search Code](https://github.com/tareq97/assignment/blob/master/Binary/Binary.java)
[Binary Search With Random Sorted Array between range 0 to 1000](https://github.com/tareq97/assignment/blob/master/Binary/BinarySearchRandom.java)
