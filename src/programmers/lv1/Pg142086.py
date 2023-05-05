# 가장 가까운 같은 글자

def solution(s):
    s = s[::-1]
    answer = [-1 for i in range(len(s))]
    for i in range(len(s) - 1):
        for j in range(i + 1, len(s)):
            if s[i] == s[j]:
                answer[len(s) - i - 1] = j - i
                break;

    return answer