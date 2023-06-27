# 제일 작은 수 제거하기

def solution(arr):
    if len(arr) == 1:
        arr = []
        arr.append(-1)
    else:
        arr.remove(min(arr))
    return arr