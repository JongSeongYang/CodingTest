# 자연수 뒤집어 배열로 만들기

def solution(n):
    answer = []
    s = reversed(str(n))
    for i in s:
        answer.append(int(i))
    return answer