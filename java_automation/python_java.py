# execute "java CustomToWylie" in terminal from python
import os

command_to_execute = 'java CustomToWylie གནས་ཚལ་དང'

with os.popen(command_to_execute) as f:
    result = f.readlines()

print(result)