from zeep import Client


wsdl_url = 'http://localhost:8080/WebServicesGlass/HelloWorldImplService?WSDL'
client = Client(wsdl=wsdl_url)

response = client.service.getHelloWorldAsString("Klient python")

print("Odpowiedź z serwisu:\n", response)

products = client.service.getProducts()
print("Produkty:")
for p in products:
    print(f"- {p['nazwa']} | {p['opis']} | {p['cena']} zł")
