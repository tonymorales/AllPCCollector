# AllPCCollector

This is a small service for collect data and properties of workstations in domain network. It registers the property changings of workstation and users login events.

This is early version in development process.

### How it works:
The application accepts POST-requests on http://examlpe/sendinfo:8090 from workstations. Workstation have the little client app, that collects info on Windows startup and make a post request to AllPCCollector.
All info persists in MySQL database.
___

### How to start

Download sources. 
Build maven project, run:
```bash
mvn package
```

To start app you must run from ./target directory:
 ```bash
 java -jar AllPCCollector-1.0-SNAPSHOT.jar
```  
You can send POST-request with json

##### JSON Example
```javascript
{
  "datetime": "11.11.2017 11:11:11",
  "computer": {
    "computerName": "myPC",
    "cpuId": "BFEBFEEF111116D7",
    "computerProperties": [
      {
        "value": "192.168.1.2",
        "propertyType": {
          "name": "ip",
          "title": "Ip address"
        }
      },
      {
        "value": "902B34CC4A08",
        "propertyType": {
          "name": "mac",
          "title": "MAC address"
        }
      }
    ]
  },
  "user": {
    "username": "A.Ivanov"
  }
}
```
