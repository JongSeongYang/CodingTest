# 모의고사

def solution(answers):
    supojas = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    res = []
    for person in supojas:
        k, count = 0, 0
        length = len(person)
        for ans in answers:
            if ans == person[k]:
                count += 1
            k += 1
            k %= length
        res.append(count)

    maxvalue = max(res)
    answer = []
    for i in range(3):
        if res[i] == maxvalue:
            answer.append(i + 1)
    return answer