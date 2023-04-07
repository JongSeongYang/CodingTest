# 크레인 인형뽑기 게임

def solution(board, moves):
    answer = 0
    basket = []
    line_height = []
    for i in range(len(board[0])):
        for j in range(len(board)):
            if board[j][i] != 0:
                line_height.append(j)
                break
    for i in range(len(moves)):
        pop_num = -1
        recent = 0
        move = moves[i]-1
        if line_height[move] == len(board):
            continue
        else:
            if board[line_height[move]][move] != 0:
                pop_num = board[line_height[move]][move]
                line_height[move]+=1
                if len(basket) == 0:
                    basket.append(pop_num)
                else:
                    recent = basket.pop()
                    if pop_num != recent:
                        basket.append(recent)
                        basket.append(pop_num)
                    else:
                        answer+=2
    return answer