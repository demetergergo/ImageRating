import { ImageDto, CreateImageDto } from './imageTypes';

export interface PostDto {
  id: string; 
  title: string;
  description: string;
  images: ImageDto[];
  createdOn: string
  updatedOn: string;
}

export interface CreatePostDto {
  title: string;
  description: string;
  images: CreateImageDto[];
}

export interface PostUpdateDto {
  id: string;
  title: string;
  description: string;
}
