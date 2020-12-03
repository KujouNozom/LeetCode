while True:
    row, col = map(int, input().split(','))
    if not (row and col):
        print(0)
        continue

    input_datas = []
    for _ in range(row):
        input_datas.append(input().split(','))

    dp = []
    for _ in range(row):
        temp_row = []
        for _ in range(col):
            temp_row.append([0, 0, 0])

        dp.append(temp_row)

    dp[0][0] = [1, 1, 1] if input_datas[0][0] == 'M' else [0, 0, 0]
    fwi = [-1, 0, -1]
    fwj = [0, -1, -1]
    ans = 0
    for i in range(row):
        for j in range(col):
            if input_datas[i][j] == 'M':
                for index in range(0, 3):
                    temp_i = i + fwi[index]
                    temp_j = j + fwj[index]
                    if 0 <= temp_i < row and 0 <= temp_j < col:
                        dp[i][j][index] = dp[temp_i][temp_j][index] + 1
                    else:
                        dp[i][j][index] = 1
                    ans = max(ans, dp[i][j][index])
    print(ans)
