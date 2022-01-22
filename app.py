# -*- coding: utf-8 -*-
"""
Created on Sat Jan 22 19:39:41 2022

@author: Keerthika
"""

import numpy as np
from flask import Flask, request, jsonify
import pickle
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import OneHotEncoder
import pandas as pd


model = pickle.load(open('model.pkl', 'rb'))
print('model is loaded')
app = Flask(__name__)
dataset = pd.read_csv('Wellbeing_and_lifestyle_data_Kaggle.csv')

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
    
    X = dataset.iloc[:, 1:-1].values
    ct = ColumnTransformer(transformers=[('encoder', OneHotEncoder(), [-2])], remainder='passthrough')
    X = np.array(ct.fit_transform(X))
    test=[[FRUITS_VEGGIES,
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
          GENDER]]
    test=ct.transform(test)
    pred=model.predict(test)
    return jsonify(prediction=str(round(pred[0],2)))

if __name__ == "__main__":
    app.run(debug=True)
