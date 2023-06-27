# 둘만의 암호

def solution(s, skip, index):
    answer = ''
    abc = 'abcdefghijklmnopqrstuvwxyz'
    for i in range(len(skip)):
        abc = abc.replace(skip[i],'')
    for i in range(len(s)):
        idx = abc.find(s[i])
        answer += abc[(idx+index)%len(abc)]
    return answer

