# 신고 결과 받기

def solution(id_list, report, k):
    answer = []
    d = {}
    for i in range(len(id_list)):
        arr = set()
        d[id_list[i]] = arr
        answer.append(0)

    s = set(report)
    report = list(s)
    for i in range(len(report)):
        name = report[i].split(" ")
        d[name[1]].add(name[0])
    for key in d.keys():
        if len(d[key]) >= k:
            for i in d[key]:
                idx = id_list.index(i)
                answer[idx] += 1
    return answer