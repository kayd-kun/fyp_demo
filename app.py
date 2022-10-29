from flask import Flask, render_template, request, jsonify
import os

app = Flask(__name__)

@app.route("/", methods=['GET', 'POST'])
def index():
    if request.method == "POST":
        print("Post HIT")
        text = request.get_json() # Dict
        text = text['inputText']
        
        print("==============")
        # print(text)
        # Return The text to display

        # TODO: Get the Transcribe and return it
        path_to_java_class = 'CustomToWylie'
        command_to_execute = 'java ' + path_to_java_class + ' ' + text
        with os.popen(command_to_execute) as f:
            # index 0: Output
            # index 1: Status 1 = Success, 0 = Failure
            result = f.readlines()
        
        wylie = result[0].strip()
        print(wylie)
        
        return jsonify(transcribe=wylie)
       

    return render_template("index.html")