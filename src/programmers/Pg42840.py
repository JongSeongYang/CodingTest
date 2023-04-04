# 모의고사

def solution(answers):
    first = [1,2,3,4,5]
    second = [2,1,2,3,2,4,2,5]
    third = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]
    answer = []
    for i in range(len(answers)):
        if first[i%len(first)] == answers[i]:
            score[0]+=1
        if second[i%len(second)] == answers[i]:
            score[1]+=1
        if third[i%len(third)] == answers[i]:
            score[2]+=1
    max_score = max(score)
    for i in range(len(score)):
        print(score[i])
        if max_score == score[i]:
            answer.append(i+1)
    return answer