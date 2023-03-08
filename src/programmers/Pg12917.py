# 문자열 내림차순으로 배치하기

def solution(s):
    l = list(s)
    l.sort(reverse=True)
    return ''.join(l)