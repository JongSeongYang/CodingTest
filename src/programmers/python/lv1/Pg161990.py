# 바탕화면 정리

def solution(wallpaper):
    answer = [-1, -1, -1, -1]
    for i in range(len(wallpaper)):
        if '#' in wallpaper[i]:
            if answer[0] == -1:
                answer[0] = i
                answer[2] = i + 1
            else:
                answer[2] = i + 1
            for j in range(len(wallpaper[i])):
                if wallpaper[i][j] == '#':
                    if answer[1] == -1:
                        answer[1] = j
                        answer[3] = j + 1
                    else:
                        if answer[1] > j:
                            answer[1] = j
                        if answer[3] < j + 1:
                            answer[3] = j + 1

    return answer

# def solution(wall):
#     a, b = [], []
#     for i in range(len(wall)):
#         for j in range(len(wall[i])):
#             if wall[i][j] == "#":
#                 a.append(i)
#                 b.append(j)
#     return [min(a), min(b), max(a) + 1, max(b) + 1]