import axios from 'axios';

const API_URL = 'http://localhost:8080/courses'; // Replace with your actual API endpoint

// Function to fetch courses
export const fetchCourses = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching courses:', error);
    throw error;
  }
};
