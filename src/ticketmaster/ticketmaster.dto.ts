export interface TicketmasterVenue {
  name?: string;
  city?: TicketmasterCity;
  state?: TicketmasterState;
  location?: TicketmasterLocation;
}

export interface TicketmasterCity {
  name?: string;
}

export interface TicketmasterState {
  stateCode?: string;
}

export interface TicketmasterLocation {
  latitude?: string;
  longitude?: string;
}

export interface TicketmasterAttraction {
  id?: string;
  name?: string;
}

export interface TicketmasterStart {
  localDate?: string;
  localTime?: string;
}

export interface TicketmasterDates {
  start?: TicketmasterStart;
}

export interface TicketmasterNamedItem {
  name?: string;
}

export interface TicketmasterClassification {
  genre?: TicketmasterNamedItem;
  subGenre?: TicketmasterNamedItem;
}

export interface TicketmasterEventRelations {
  attractions?: TicketmasterAttraction[];
  venues?: TicketmasterVenue[];
}

export interface TicketmasterEvent {
  id?: string;
  name?: string;
  url?: string;
  dates?: TicketmasterDates;
  classifications?: TicketmasterClassification[];
  _embedded?: TicketmasterEventRelations;
}

export interface TicketmasterPage {
  size?: number;
  totalElements?: number;
  totalPages?: number;
  number?: number;
}

export interface TicketmasterEventsEmbedded {
  events?: TicketmasterEvent[];
}

export interface TicketmasterEventsResponse {
  _embedded?: TicketmasterEventsEmbedded;
  page?: TicketmasterPage;
}
