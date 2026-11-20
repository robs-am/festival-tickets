import { Injectable } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';
import { TicketmasterEventsResponse } from './ticketmaster.dto.js';

@Injectable()
export class TicketmasterClient {
  constructor(private readonly config: ConfigService) {}
  async searchEvents(keyword: string): Promise<TicketmasterEventsResponse> {
    const baseUrl = this.config.getOrThrow<string>('TICKETMASTER_BASE_URL');
    const url = new URL(`${baseUrl}/events.json`);
    url.searchParams.set('keyword', keyword);
    url.searchParams.set('countryCode', 'BR');
    url.searchParams.set(
      'apikey',
      this.config.getOrThrow<string>('TICKETMASTER_API_KEY'),
    );
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Failed to fetch events: ${response.status}`);
    }
    return (await response.json()) as TicketmasterEventsResponse;
  }
}
