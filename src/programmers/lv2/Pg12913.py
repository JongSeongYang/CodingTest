# 땅따먹기

def solution(land):
    answer = 0
    h = len(land)
    dp = [[0]*4 for i in range(h)]
    dp[0] = land[0]
    for i in range(1,h):
        for j in range(4):
            tmp = dp[i-1][j]
            dp[i-1][j] = 0
            dp[i][j] = land[i][j]+max(dp[i-1])
            dp[i-1][j] = tmp
    return max(dp[h-1])