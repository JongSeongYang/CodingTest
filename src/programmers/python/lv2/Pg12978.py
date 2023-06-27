# 배달

def solution(N, road, K):
    answer = 1
    max_ans = 50*10000
    board = [[max_ans]*N for i in range(N)]
    for i in range(len(road)):
        board[road[i][0]-1][road[i][1]-1] = min(road[i][2], board[road[i][0]-1][road[i][1]-1])
        board[road[i][1]-1][road[i][0]-1] = min(road[i][2], board[road[i][1]-1][road[i][0]-1])
    for k in range(N):
        for i in range(N):
            for j in range(N):
                board[i][j] = min(board[i][j], board[i][k]+board[k][j])
                board[j][i] = board[i][j]
    for i in range(1,N):
        if board[0][i] <= K:
            answer+=1
    return answer