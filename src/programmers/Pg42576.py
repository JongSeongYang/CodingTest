# 완주하지 못한 선수

def solution(participant, completion):
    p = sorted(participant)
    c = sorted(completion)
    print(p)
    print(list(p))
    answer =''
    for i in range(0,len(c)):
        if p[i] != c[i]:
            return p[i]