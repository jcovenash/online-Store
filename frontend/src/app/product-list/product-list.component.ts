import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  displayedColumns: string[] = ['name', 'price', 'action'];
  products: any[] = [
    { name: 'Celular Iphone', price: 5000 },
    { name: 'Laptop Dell', price: 15000 },
    { name: 'Televisor Samsung', price: 8000 }
  ];

  constructor(private http: HttpClient) { }

  ngOnInit(): void { }

  buyProduct(product: any): void {
    this.http.post('http://localhost:8082/orders', {
      userId: 11, // Ejemplo de userId
      product: product.name,
      price: product.price
    }).subscribe(response => {
      console.log('Orden enviada:', response);
    }, error => {
      console.error('Error al enviar la orden:', error);
    });
  }
}
