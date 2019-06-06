Import maven module into eclipse or Intelij
Run TransferHandlerRestStartup class so that API will run on http://localhost:9998/
Import postman collection from https://github.com/ChaitanyaNaidu/LND/blob/master/InitiateTransferV01/InitiateTransfersV01.postman_collection.json

URL :POST http://localhost:9998/v1/customers/1234/transfers
Sample POST request: {
	"from": "020119945",
	"to":"020119944",
	"amount":10000.0,
	"payment_reference": "investment",
	"purpose_of_transaction": "investment"
}

URL:GET http://localhost:9998/v1/customers/1234/transfers
Sample Response:
[
    {
        "id": "1228682323",
        "from": "020119945",
        "to": "020119944",
        "amount": 10000,
        "payment_reference": "investment",
        "purpose_of_transaction": "investment"
    },
    {
        "id": "372059510",
        "from": "020119945",
        "to": "020119944",
        "amount": 10000,
        "payment_reference": "investment",
        "purpose_of_transaction": "investment"
    }
]
