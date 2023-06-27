# 대충 만든 자판

def solution(keymap, targets):
    answer = []
    for target in targets:
        tabs = 0
        for t in target:  # 각 글자들에 대해서
            tab = 101
            flag = False
            for j in range(len(keymap)):  # 자판별로 몇번 눌러야 하는지 확인
                if t in keymap[j]:
                    tab = min(keymap[j].index(t) + 1, tab)
                    flag = True

            if not flag:
                tabs = -1
                break
            tabs += tab
        answer.append(tabs)
    return answer