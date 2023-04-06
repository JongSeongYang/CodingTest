# 실패율

from functools import cmp_to_key

def solution(N, stages):
    stages.sort()
    answer = []
    fail = {}
    reach = len(stages)
    for i in range(1, N+1):
        not_clear = stages.count(i)
        if reach == 0:
            fail[i] = 0
        else:
            fail[i] = not_clear/reach
        reach-=not_clear
    l = sorted(fail.items(), key=cmp_to_key(compare))
    for i in range(len(l)):
        answer.append(l[i][0])
    return answer

def compare(a,b):
	# 정렬 조건
    if a[1] > b[1]:
        return -1
    elif a[1]==b[1]:
        if a[0] > b[0]:
            return 1
        elif a[0] < b[0]:
            return -1
        else:
            return 0
    else:
        return 1