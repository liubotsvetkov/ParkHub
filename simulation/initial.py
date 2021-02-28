from datetime import datetime
import json
import random
import threading
import time
import numpy as np
import requests
import csv

url = 'https://2.python-requests.org/en/master/user/quickstart/#make-a-request'

'''
class Slot:
	def __init__(self, city, neigh, parking, slot_id, longi, lat):
		self.state = 0  # 0 free, 1 taken
		self.dateTimeUpdated = datetime.now()
		self.name = city
		self.zoneIdent = parking
		self.slotIdent = slot_id
		self.longitude = longi
		self.latitude = lat


	#def update(self):
	#	self.State ^= 1  # toggle the state with xor
	#	self.Last_up = datetime.now()

	#def notify(self):
	#	return json.dumps({"State" : self.State, "Last_up" : self.Last_up, "slot_id" : self.slot_id}, indent=4, default=str)

	def pp(self):
		return [str(self.state), str(self.dateTimeUpdated), str(self.zoneIdent), str(self.slotIdent)]
'''


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


#print(json.dumps(PLACE))

#my_objects = []

samplefile = "temp.csv"
writer = csv.writer(open(samplefile, "w"))

L = []

for city_key, city_val in PLACE.items():
	for neigh_key, neigh_val in city_val.items():
		for parking_key, parking_value in neigh_val.items():
			for ind in np.arange(parking_value[0]):
				#obj = Slot(city_key, neigh_key, parking_key, ind, parking_value[1]+0.0001*ind, parking_value[2]+0.0001*ind)
				#my_objects.append(obj)
				#writer.writerow(obj.pp())
				writer.writerow(["0", str(datetime.now()), str(parking_key), str(ind)])


				#print(json.dumps(obj.__dict__, indent=4, default=str))
				#try:
				#r = requests.post(url, data = json.dumps(obj.__dict__, indent=4, default=str))
				d = 	{
							"name": city_key,
							"parkingZones": [
								{
									"zoneIdent": parking_key,
									"parkingSlots": [
										{
											"slotIdent": int(ind),
											"dateTimeUpdated": str(np.datetime64(datetime.now())),
											"state": 0,
											"latitude": parking_value[2]+0.0001*ind,
											"longitude": parking_value[1]+0.0001*ind,
										}
									]
								}
							]
					
					}
				#print(json.dumps(d, indent=4, default=str))
				L.append(d)
				#print(json.dumps(d, indent=4, default=str))
				#r = requests.post(url, data = json.dumps(d, indent=4, default=str))
				#r.raise_for_status()
				#except r.exceptions.HTTPError as err:
				#	print(err)

r = requests.post(url, data = json.dumps(L), headers = {'Content-type':'application/json', 'Accept':'application/json'})
print(r.status_code)
#print(r.status)
#print(r.raise_for_status())


#for elem in my_objects:
#	print(json.dumps(elem.__dict__, indent=4, default=str))

'''
{
    "name": null,
    "parkingZones": [
        {
            "zoneIdent": null,
            "parkingSlots": [
                {
                    "slotIdent": null,
                    "dateTimeUpdated": null,
                    "state": 0,
                    "latitude": 0.0,
                    "longitude": 0.0,
                }
            ]
        }
    ]
}
'''