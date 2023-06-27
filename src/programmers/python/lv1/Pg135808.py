# 과일 장수

def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    for i in range(0,len(score),m):
        if i+m <= len(score):
            arr = score[i:i+m]
            answer += min(arr)*m
    return answer