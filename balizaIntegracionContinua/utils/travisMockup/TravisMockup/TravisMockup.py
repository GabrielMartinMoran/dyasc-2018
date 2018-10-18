from flask import Flask, request, jsonify, render_template

class testClass:
    pass

VALID_TOKEN = "9cHb1xMQyaGSSSsi6xTW5Q"
VALID_API_VERSION = "3"
SERVER_DOMAIN = "http://localhost"
PORT=8080

build_status = "passed"

app = Flask(__name__)

def has_valid_headers(headers):
    api_version = None
    token = None
    try:
        api_version = headers['Travis-API-Version']
        token = headers['Authorization']
    except:
        return False
    if (api_version == VALID_API_VERSION and ("token " + VALID_TOKEN) == token):
        return True
    return False

def generate_build_state():
    return {
        "builds": [
                {
                "state": build_status
                }
            ]
        }

@app.route('/repo/<username>/<repository>/builds', methods=['GET'])
def get_build_satus(username, repository):
    headers_valid = has_valid_headers(request.headers)
    if(not headers_valid):
        return "access denied"
    build_state = generate_build_state()
    return jsonify(build_state)

@app.route('/config', methods=['GET'])
def config():
    return render_template("config.html", SERVER_URL=SERVER_DOMAIN+":"+str(PORT))

@app.route('/set_status/<status>', methods=['GET'])
def set_build_satus(status):
    global build_status
    build_status = status
    return "OK"

def run_app():
    app.run(host="0.0.0.0",port=PORT)

if __name__ == '__main__':
    run_app()