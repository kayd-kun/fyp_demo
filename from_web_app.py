import os

text = 'གནས་ཚལ་དང'
path_to_java_class = 'CustomToWylie'
command_to_execute = 'java ' + path_to_java_class + ' ' + text
with os.popen(command_to_execute) as f:
    # index 0: Output
    # index 1: Status 1 = Success, 0 = Failure
    result = f.readlines()

print('=======================')
print(result)