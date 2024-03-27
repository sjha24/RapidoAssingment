# RapidoAssingment
## Create Shipmet
  * @RequestMapping("/rapido)
  * @PostMapping("/shipment") -> this take a request Body call Shipment
  * Shipment Structure in JSON
  * ```
    {
    "senderName":"SK Jha",
    "senderAddress":"Bhopal Sundarnagar",
    "recipientName":"Subham",
    "recipientAddress":"Delhi jn",
    "currentLocation" : "Bhopal",
    "packageDetails": {
        "dimensions": {
        "length": 10,
        "width": 7,
        "height": 10
        }
      }
    }
    ```
## Update Shipment
 * @PatchMapping("/{shipmentId})
 * take one path variable and RequestBody ShipmentUpdate
 * Shipment body look like this in JSON format

   ```
    {
    "status":"Dispatch",
    "currentLocation":"Kiul"
    }
   ```
   
![Screenshot (310)](https://github.com/sjha24/RapidoAssingment/assets/98340874/ae96d12b-bf9e-4622-bd07-2793bfb67d3e)

## Tracking Shipment
 * @PostMapping("/track/{trackingId})
 * take only one path variable
![Screenshot (311)](https://github.com/sjha24/RapidoAssingment/assets/98340874/f3fc8624-7269-4527-86d6-5ccd5e3a4b82)

## Buy Shipment
 * @PostMapping("{shipmentId}/buy)
 * take only one path variable 
![Screenshot (312)](https://github.com/sjha24/RapidoAssingment/assets/98340874/27c55ac7-fcd3-4b0e-83b1-f00b30c7f5a6)


## Quote
 * @PostMapping("/quote)
 * that take on requestBody call quote Request
 * Quote request look like this in JSON format
   ```
   {
      "origin":"Kajra , India,Bihar",
      "destination":"Delhi ,India",
       "packageDetails": {
        "dimensions": {
        "length": 10,
        "width": 5,
        "height": 8
        }
      }
   }
   ```

![Screenshot (309)](https://github.com/sjha24/RapidoAssingment/assets/98340874/2360e29a-493b-4871-a169-350b47130e2c)

## Scheduled Pickup
 * PostMapping("/pickup)
 * take one RequestBody call PickupRequest
 * PickupRequest looks like this in JSON format
   ```
   {   
    "shipmentId": 3,
    "pickupDate": "2024-03-31T15:00:00",
    "location": "Bhopal Sundarnagar",
    "specialInstructions": "Leave package at the back door."
   }
   ```
![Screenshot (313)](https://github.com/sjha24/RapidoAssingment/assets/98340874/2c15cd4d-9514-4507-8bf5-87630740aaa3)

## Register user
 @RequestMapping("user")
 * PostMapping("/register)
 * take one requestBody call user
 * User in JSON format
   ```
   {
    "username": "Saurav",
   "password": "password12",
   "email": "sk@gamil.com",
   "role": "CUSTOMER"
   }
   ```

![Screenshot (314)](https://github.com/sjha24/RapidoAssingment/assets/98340874/af87925d-0743-4249-93df-e2c843a1902d)

## Login User
 * PostMapping("/login)
 * take RequsetBody call LoginRequest
 * LoginRequest in JSON format
   ```
   {
    "email": "saurav@gamil.com",
    "password": "password12"
    }
   ```

![Screenshot (315)](https://github.com/sjha24/RapidoAssingment/assets/98340874/5282e00b-2a31-4aba-925f-8b62eb4bcc3c)
