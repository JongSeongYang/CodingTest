# 기능 개선

def solution(progresses, speeds):
    answer = []
    while progresses:
        count = 0
        while progresses and progresses[0]>=100:
            count+=1
            progresses.pop(0)
            speeds.pop(0)
        for i in range(len(progresses)):
            progresses[i]+=speeds[i]

        if count!=0:
            answer.append(count)
    return answer