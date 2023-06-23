# [3차] 압축

def solution(msg):
    answer = []
    dic = {}
    num = 27
    for i in range(1, 27):
        dic[chr(i + 64)] = i
    while msg != '':
        idx = 0
        ans = 0
        for j in range(1, len(msg) + 1):
            # i번째까지 슬라이싱
            m = msg[:j]
            if m in dic.keys():
                ans = dic[m]
                idx = j
            else:
                dic[m] = num
                num += 1
                break
        msg = msg[idx:]
        answer.append(ans)

    return answer