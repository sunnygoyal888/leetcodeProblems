# Power Functions Full Analysis

Exponentiation is a mathematical operation that is expressed as x^n and computed as x^n = x.x.x....x(n times).

We have two methods for calculating exponents, recursive and iterative.

### Basic method 

While calculating x^n, the most basic solution is broken down into x.x^(n-1). The new problem is x^(n-1), which is similar to the original problem. 
Therefore, like in original problem, it is further broken down to x.x.x^(n-2).

This is the recursive approach to find x^n.

Also we know base case will be, n == 0 here ans = 1

```java
int recursivePower(int x,int n) {
    if(n == 0) return 1;
    return x*recursivePower(x,n-1);
}
```

Time complexity:

With respect to time complexity, it is a fairly efficient O(n) solution.
However, when it comes to finding , where can be as large as 10^15 , this solution will not be suitable.
___
### Optimized method

While calculating x^n, n can be odd or even.

If n is even, then n can be broken down to (x^2)^(n/2). Finding x^2 is a one-step process.
However, finding (A)^(n/2) will take some time here A = x^2.

When x^n is odd, we can convert it into an even value. x^n can be written as x.x^(n-1).
This ensures that (n-1) is even. So it can be again broken down to (n-1)/2 in next step.

Notice how the computation steps were reduced from n to n/2 in just one step.
You can continue to divide the power by 2 as long as it is even or if it's odd make it even.

**Approach has two steps:**

- If n is even, replace x^n by (x^2)^(n/2).
- If n is odd, replace x^n by x.x^(n-1). n-1 becomes even and you can apply the relevant formula again.

**Example:**

We need to find 5^10

Naive approach will be,
```
5^10 = 5.5^9
     = 5.5.5^8
     = 5.5.5^7
     = 5.5.5.5^6
     = 5.5.5.5.5^5
     = 5.5.5.5.5.5^4
     = 5.5.5.5.5.5.5^3
     = 5.5.5.5.5.5.5.5^2
     = 5.5.5.5.5.5.5.5.5^1
     = 5.5.5.5.5.5.5.5.5.1
```

We can see it took us n steps to find 5^n

Optimal Approach
```
5^10 = (5^2)^5
     = 25.25^4
     = 25.(25^2)^2
     = 25.(625)^2
     = 25.625.625
```
This is an efficient method and the ten-step process of determining 5^10 is reduced to a four-step process. At every step, n is divided by 2.

Time Complexity

Therefore, the time complexity is O(log N).

```java
int binaryExponentiation(int x,int n) {
    if(n==0) return 1;
    //n is even
    else if(n%2 == 0)        
        return binaryExponentiation(x*x,n/2);
    //n is odd
    else                             
        return x*binaryExponentiation(x*x,(n-1)/2);
}
```
___
### Modulo Exponetiation

However, storing answers that are too large for their respective datatypes is an issue with this method.
In such instances, you must use modulus (%). Instead of finding x^n, you must find (x^n) % M.

For example, run the implementation of the method to find . The solution will timeout, while the solution will run in time but it will produce garbage values.

If we needed to find 2^(10^5) or something big, then approach will run in O(logn) time, but produces garbage values as ans.

```java
int modularExponentiation(int x, int n, int M) {
    if(n==0) return 1;
    //n is even
    else if(n%2 == 0)        
        return modularExponentiation((x*x) % M, n/2, M);
    //n is odd
    else                             
        return (x*modularExponentiation((x*x) % M, (n-1)/2, M)) % M;
}
```

Time complexity: O(log N)

Memory complexity: O(log N) because a function call consumes memory and log N recursive function calls are made
> Note: Iterative ways more optimal, because recursive solutions require stack memory.
> 
> Also sometimes, (x*x) even can run out of int limit
