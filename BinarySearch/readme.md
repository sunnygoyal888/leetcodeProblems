# Binary Search Basics

### Floor and Ceil
```java
// For Floor element
int res = -1;
if(arr[mid] < x) {
  res = arr[mid];
  start = mid + 1;
}

// For floor index -> simply return hi or lo-1

// For Ceil element
int res = -1;
if(arr[mid] > x) {
  res = arr[mid];
  end = mid - 1;
}

// For ceil index -> simply return lo or hi+1
```
___
### First and Last Occurence of an Element
```java
// For 1st occurence
int res = -1;
if(arr[mid] == ele) {
  res = mid;
  end = mid - 1;
}

// For last occurence
int res = -1;
if(arr[mid] == ele) {
  res = mid;
  start = mid + 1;
}
```
___
### Count of an Element in a Sorted Array
```java
int first = BS(arr, ele);
if(first == -1){
  return 0;
}
int last = BS(arr, ele);
return (last - first + 1);
```
