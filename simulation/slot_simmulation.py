from datetime import datetime
import json
import random
import threading
import time
import numpy as np
import requests
import csv

url = 'https://www.w3schools.com/python/demopage.php'

TIME_TO_UPDATE_IN_S = 10



PLACE = {"SOF": {
				"Boyana" :
							{"A1" : [10, 42.644885, 23.271186],
							"A2" : [32, 42.650910, 23.283420]},
				"SouthPark" :
							{"C1" : [5, 42.672024, 23.312357],
							"C2" : [20, 42.659372, 23.314266]},
				"Orlandovtsi" :
							{"OR1" : [4, 42.725643, 23.321553],
							"OR2" : [20, 42.736193, 23.328410]}},


		 "BRE": {
		 		"Blumenthal":
		 					{"L1" : [10, 53.191156, 8.557751],
		 					"L2" : [40, 53.213333, 8.580750],
		 					"L3" : [8, 53.224338, 8.504187]},
		 		"Neustadt":
		 					{"D1" : [10, 53.051828, 8.827088],
		 					"D2" : [10, 53.077957, 8.790751],
		 					"D3" : [10, 53.063580, 8.787507]},
		 		"Vegesack":
		 					{"E1" : [30, 53.168057, 8.654234]}}}

class anotherSlot:
	def __init__(self, st, lup, pid, sid):
		self.state = st  # 0 free, 1 taken
		self.last_up = lup
		self.parking = pid
		self.slot_id = sid

	def update(self):
		self.state ^= 1  # toggle the state with xor
		self.last_up = str(datetime.now())
		return {"state": int(self.state) , "last_up": self.last_up, "parking": self.parking, "slot_id": self.slot_id}

obj = []


for city_key, city_val in PLACE.items():
	for neigh_key, neigh_val in city_val.items():
		for parking_key, parking_value in neigh_val.items():
			for ind in np.arange(parking_value[0]):
				obj.append(anotherSlot(0, str(datetime.now()), str(parking_key), str(ind)))


start = time.time()
pool = []

while True:
	x = random.choice(obj)
	#y = 
	pool.append(dict(x.update()))
	time.sleep(random.uniform(0.5, 2))
	if (time.time() - start) >= TIME_TO_UPDATE_IN_S:

		r = requests.post(url, data = json.dumps(pool), headers = {'Content-type':'application/json', 'Accept':'application/json'})
		print(r.status_code)
		start = time.time()
		pool = []

	#while (time.time() - start >= 2):
	#	print("X")

'''
for _ in np.arange(transitions):
	x = random.choice(my_objects)
	x.update()
	print(json.dumps(x.__dict__, indent=4, default=str))
	r = requests.post(url, data = json.dumps(x.__dict__, indent=4, default=str))
	print(r.status_code)
'''