
export interface ImageDto {
  id: string; 
  photoUrl: string;
  rating: number;
}

export interface CreateImageDto {
  photoUrl: string;
  rating: number;
}
