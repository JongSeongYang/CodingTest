# 나머지가 1이 되는 수 찾기

def solution(n):
    answer = n
    for i in reversed(range(2,n)):
        if n%i == 1:
            answer = i
    return answer