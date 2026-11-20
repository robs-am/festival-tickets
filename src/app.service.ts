import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class AppService {
  constructor(private readonly config: ConfigService) {}

  getHello(): string {
    const apiKey = this.config.get<string>('TICKETMASTER_API_KEY');
    return apiKey ? 'Chave da Ticketmaster carregada!' : 'Chave NÃO encontrada';
  }
}