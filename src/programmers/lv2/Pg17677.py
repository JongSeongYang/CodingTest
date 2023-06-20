# [1차] 뉴스 클러스터링

def solution(str1, str2):
    answer = 0
    l1 = scliceString(str1)
    l2 = scliceString(str2)
    union = []
    common = []
    if len(l1) == 0 and len(l2) == 0:
        answer = 1
    elif len(l1) == 0 or len(l2) == 0:
        answer = 0
    else:
        tmp = l1.copy()
        union = l1.copy()
        for i in l2:
            if i not in tmp:
                union.append(i)
            else:
                tmp.remove(i)
        for i in l2:
            if i in l1:
                l1.remove(i)
                common.append(i)
        answer = len(common)/len(union)
        print(answer)
    return int(answer*65536)

def scliceString(str):
    result = []
    for i in range(len(str)-1):
        s = str[i:i+2]
        s = s.lower()
        if 97 <= ord(s[0]) <= 122 and 97 <= ord(s[1]) <= 122:
            result.append(s)
    return result