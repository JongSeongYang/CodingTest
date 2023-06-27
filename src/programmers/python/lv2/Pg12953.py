# N개의 최소공배수

import math
def solution(arr):
    lcm = 0
    if len(arr) == 1:
        lcm = arr[0]
    elif len(arr) == 2:
        lcm = arr[0]*arr[1] // math.gcd(arr[0],arr[1])
    else:
        lcm = arr[0]*arr[1] // math.gcd(arr[0],arr[1])
        for i in range(2,len(arr)):
            lcm = arr[i]*lcm //math.gcd (arr[i],lcm)
    return lcm