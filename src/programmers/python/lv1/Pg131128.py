# 숫자 짝꿍

def solution(X, Y):
    answer = []
    xDict = dict()
    yDict = dict()
    for x in X:
        xDict[x] = xDict.get(x, 0) + 1
    for y in Y:
        yDict[y] = yDict.get(y, 0) + 1

    for k, v in xDict.items():
        if k in yDict.keys():
            while yDict[k] > 0 and xDict[k] > 0:
                answer.append(k)
                yDict[k] = yDict.get(k) - 1
                xDict[k] = xDict.get(k) - 1

    if (len(answer) == 0):
        return "-1"
    if (answer.count('0') == len(answer)):
        return "0"
    answer.sort(reverse=True)
    return ''.join(answer)