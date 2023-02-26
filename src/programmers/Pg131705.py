# 삼총사

from itertools import combinations

def solution(number):
    answer = 0
    p = list(combinations(number, 3))

    for l in p:
        sum = 0
        for i in range(3):
            sum += l[i]
        if sum == 0:
            answer += 1

    return answer