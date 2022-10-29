with open('containing_numbers.txt', 'r') as f:
    dz = f.readlines()

print(len(dz))


def norm(char):
    if char == '༡':
        return 'གཅིག་ '
    elif char == '༢':
        return 'གཉིས་ '
    elif char == '༣':
        return 'གསུས་ '
    elif char == '༤':
        return 'བཞི་ '
    elif char == '༥':
        return 'ལྔ་ '
    elif char == '༦':
        return 'དྲུག་ '
    elif char == '༧':
        return 'བདུན་ '
    elif char == '༨':
        return 'བརྒྱད་ '
    elif char == '༩':
        return 'དགུ་ '
    elif char == '༠':
        return 'ཀླད་ཀོར་ '
    else:
        return char

s = "མོ་ སྤྱི་ལོ་ ༡༢༣༤༥༦༧༨༩ ལུ་ཚེ་ལས་འདས་ནུག།"

normalized_ds = []
for line in dz:
    normalized = ''
    for char in line:
        char_normalized = norm(char)
        normalized += char_normalized
    normalized_ds.append(normalized)

with open('normalized_no.txt', 'w') as f:
    for line in normalized_ds:
        line.strip()
        f.write(f'{line}')

# normalized = ""
# for char in s:
#     char_normalized = norm(char)
#     normalized += char_normalized

# print('Normalized string: ', normalized)