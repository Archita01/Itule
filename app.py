import numpy as np
from flask import Flask, request, jsonify
import pickle
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import OneHotEncoder


model = pickle.load(open('model.pkl', 'rb'))
print('model is loaded')
app = Flask(__name__)

@app.route('/',methods=['GET'])
def index():
    FRUITS_VEGGIES=float(request.args['FRUITS_VEGGIES'])
    DAILY_STRESS=float(request.args['DAILY_STRESS'])
    PLACES_VISITED=float(request.args['PLACES_VISITED'])
    CORE_CIRCLE=float(request.args['CORE_CIRCLE'])
    SUPPORTING_OTHERS=float(request.args['SUPPORTING_OTHERS'])
    SOCIAL_NETWORK=float(request.args['SOCIAL_NETWORK'])
    ACHIEVEMENT=float(request.args['ACHIEVEMENT'])
    DONATION=float(request.args['DONATION'])
    BMI_RANGE=float(request.args['BMI_RANGE'])
    TODO_COMPLETED=float(request.args['TODO_COMPLETED'])
    FLOW=float(request.args['FLOW'])
    DAILY_STEPS=float(request.args['DAILY_STEPS'])
    LIVE_VISION=float(request.args['LIVE_VISION'])
    SLEEP_HOURS=float(request.args['SLEEP_HOURS'])
    LOST_VACATION=float(request.args['LOST_VACATION'])
    DAILY_SHOUTING=float(request.args['DAILY_SHOUTING'])
    SUFFICIENT_INCOME=float(request.args['SUFFICIENT_INCOME'])
    PERSONAL_AWARDS=float(request.args['PERSONAL_AWARDS'])
    TIME_FOR_PASSION=float(request.args['TIME_FOR_PASSION'])
    WEEKLY_MEDITATION=float(request.args['WEEKLY_MEDITATION'])
    AGE=str(request.args['AGE'])
    GENDER=float(request.args['GENDER'])
    ct = ColumnTransformer(transformers=[('encoder', OneHotEncoder(),[['AGE']])], remainder='passthrough')
    
    
    pred=model.predict(np.array([FRUITS_VEGGIES,
                                 DAILY_STRESS,
                                 PLACES_VISITED,
                                 CORE_CIRCLE,
                                 SUPPORTING_OTHERS,
                                 SOCIAL_NETWORK,
                                 ACHIEVEMENT,
                                 DONATION,
                                 BMI_RANGE,
                                 TODO_COMPLETED,
                                 FLOW,
                                 DAILY_STEPS,
                                 LIVE_VISION,
                                 SLEEP_HOURS,
                                 LOST_VACATION,
                                 DAILY_SHOUTING,
                                 SUFFICIENT_INCOME,
                                 PERSONAL_AWARDS,
                                 TIME_FOR_PASSION,
                                 WEEKLY_MEDITATION,
                                 AGE,
                                 GENDER]).reshape(1,-1))
    return jsonify(str(round(pred[0],2)))
'''
?FRUITS_VEGGIES=5&DAILY_STRESS=4&PLACES_VISITED=0&CORE_CIRCLE=2&SUPPORTING_OTHERS=10&SOCIAL_NETWORK=10&ACHIEVEMENT=5
&DONATION=1&BMI_RANGE=2&TODO_COMPLETED=7&FLOW=4&DAILY_STEPS=1&LIVE_VISION=5&SLEEP_HOURS=8&LOST_VACATION=5&DAILY_SHOUTING=2&SUFFICIENT_INCOME=2&PERSONAL_AWARDS=1&TIME_FOR_PASSION=8&WEEKLY_MEDITATION=4&AGE=28&GENDER=1
'''

if __name__ == "__main__":
    app.run(debug=True)