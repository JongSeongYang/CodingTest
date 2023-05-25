# 가장 큰 정사각형 찾기

def solution(board):
    answer = 0
    w = len(board[0])
    h = len(board)
    dp = [[0] * w for _ in range(h)]
    dp[0] = board[0]
    for i in range(1, h):
        dp[i][0] = board[i][0]

    for i in range(1, h):
        for j in range(1, w):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

    for i in range(h):
        answer = max(max(dp[i]), answer)

    return answer ** 2