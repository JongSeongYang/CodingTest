# 추억 점수

def solution(name, yearning, photo):
    answer = []
    dic = dict(zip(name, yearning))
    for p in photo:
        score = 0
        for person in p:
            score += dic.get(person, 0)
        answer.append(score)
    return answer