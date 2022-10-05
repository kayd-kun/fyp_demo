from flask import Flask, render_template, request, jsonify

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
        

        return jsonify(transcribe=text)
       

    return render_template("index.html")